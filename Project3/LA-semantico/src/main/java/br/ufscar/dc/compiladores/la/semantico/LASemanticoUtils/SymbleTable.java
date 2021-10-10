/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.compiladores.la.semantico.LASemanticoUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SymbleTable {

    // Language types
    public enum TipoLA {
        LITERAL,
        INTEIRO,
        REAL,
        LOGICO,
        PONTEIRO,
        REGISTRO,
        FUNCAO,
        INVALIDO

    }

    public class Symble {
        public String nome;
        public TipoLA tipo;

        // Some complex type are a bit more difficult to implement
        public TipoLA subtipo;

        public Register register;
        public Function func;
        // Need to keep track of what add to registers
        // List???
        boolean isType;

        public Symble(String nome, TipoLA tipo) {
            this.nome = nome;
            this.tipo = tipo;
            this.subtipo = null;
            this.register = null;
            this.func = null;
            this.isType = false;

            if (tipo == TipoLA.REGISTRO) {
                this.register = new Register();
            } else if (tipo == TipoLA.FUNCAO) {
                this.func = new Function();
            }

        }

        private Symble(String nome, TipoLA tipo, TipoLA subtipo) {
            this.nome = nome;
            this.tipo = tipo;
            this.subtipo = subtipo;
            this.register = null;
            this.isType = false;
        }

        private Symble(String nome, TipoLA tipo, boolean isType) {
            this.nome = nome;
            this.tipo = tipo;
            this.subtipo = subtipo;
            this.register = new Register();
            this.isType = isType;
        }
    }

    public class Register {
        private ArrayList<Symble> variables;

        // This type should hold another symble...
        public Register () {
            this.variables = new ArrayList<Symble>();
        }

        public void addVariable(String nome, TipoLA tipo) {
            Symble var = new Symble(nome, tipo);
            this.variables.add(var);
        }

        public ArrayList<Symble> getVariables() {
            return this.variables;
        }

        public boolean containsKey (String n) {
            for (var v : variables) {
                if (n.equals(v.nome)) {
                    System.out.println("working");
                    return true;
                }
                    
            }
            System.out.println("wat");
            return false;
        }

        public TipoLA variableType (String n) {
            for (var v : variables)
                if (n.equals(v.nome))
                    return v.tipo;
            return TipoLA.INVALIDO;
        }

    }

    private final HashMap<String, Symble> tabela;
    private final ArrayList<String> registers;
    private static ArrayList<String> customTypes;
    private Integer registerCounter = 0;

    // Register Utils

    public SymbleTable() {
        tabela = new HashMap<>();
        //registerVariables = new ArrayList<String>();
        registers = new ArrayList<>();
        customTypes = new ArrayList<>();
    }
    
    public void addSymbol(String nome, TipoLA tipo) {
        tabela.put(nome, new Symble(nome, tipo));
    }

    public void addSymbol(String nome, TipoLA tipo, TipoLA subtipo) {
        tabela.put(nome, new Symble(nome, tipo, subtipo));
    }

    public void registerType(String nome, TipoLA tipo) {
        customTypes.add(nome);
        tabela.put(nome, new Symble(nome, tipo, true));

    }

    public static boolean isCustomType(String t) {
        return customTypes.contains(t);
    }

    public void instanceType(String nome, String tipo) {
        Symble obj = tabela.get(tipo);
        tabela.put(nome, new Symble(nome, TipoLA.REGISTRO));

        for (var v : obj.register.getVariables()) {
            // DEBUG
            System.out.println("Registering: "+v.nome+" "+v.tipo);
            addRegisterVariable(nome, v.nome, v.tipo);
        }
        //tabela.put(nome, new Symble(nome, tipo, true));

    }

    // I'll treat a function as an optimazed register
    public class Function {
        private ArrayList<Symble> parameters;
        private SymbleTable.TipoLA returnValue;

        // This type should hold another symble...
        public Function () {
            this.parameters = new ArrayList<Symble>();
            this.returnValue = null;
        }

        public Function (SymbleTable.TipoLA t) {
            this.parameters = new ArrayList<Symble>();
            this.returnValue = t;
        }



        public void addParameter(String nome, TipoLA tipo) {
            Symble var = new Symble(nome, tipo);
            this.parameters.add(var);
        }

        public ArrayList<Symble> getVariables() {
            return this.parameters;
        }

        public boolean containsKey (String n) {
            for (var v : parameters) {
                if (n.equals(v.nome)) {
                    System.out.println("working");
                    return true;
                }

            }
            System.out.println("wat");
            return false;
        }

        public TipoLA variableType (String n) {
            for (var v : parameters)
                if (n.equals(v.nome))
                    return v.tipo;
            return TipoLA.INVALIDO;
        }

    }
    
    public boolean existe(String nome) {
        // DEBUG: aaaa
//        if (nome.contains("."))
//            System.out.println("1: "+nome.substring(0,nome.indexOf("."))+" 2: "+nome.substring(nome.indexOf(".")+1));

        if (nome.contains("."))
            if (tabela.get(nome.substring(0,nome.indexOf("."))) != null)
                return tabela.get(nome.substring(0,nome.indexOf(".")))
                    .register.containsKey(nome.substring(nome.indexOf(".")+1));
            else
                return false;

        return tabela.containsKey(nome);
    }

    public TipoLA verificar(String nome) {
        //System.out.println("VERIFICAR: "+nome);

        // check if it is a register
//        if (nome.contains("."))
//            nome = nome.substring(nome.lastIndexOf(".") + 1);
        if (nome.contains("."))
            return tabela.get(nome.substring(0,nome.indexOf(".")))
                    .register.variableType(nome.substring(nome.indexOf(".")+1));
        if (tabela.get(nome) ==  null)
            return TipoLA.LITERAL;
        return tabela.get(nome).tipo;
    }

//    public String isChildOf(String nome) {
//        return tabela.get(nome).register;
//    }


    // Type functions

    // May find a better way of doing it
    // Remember to check if this language is case sensitive
    public static boolean typeIsValid(String typename) {

        //DEBUG:
        //System.out.println(customTypes);

        if (typename.startsWith("^")) {
            // adding pointer support
            typename = typename.replace("^", "");
            TipoLA aux = TipoLA.valueOf(typename.toUpperCase());
            if (aux == TipoLA.INVALIDO)
                return false;
            else
                return true;
            // TODO: check if this line still makes sense
        } else if (typename.startsWith("registro") && typename.endsWith("fim_registro")) {
            return true;
        } else if (customTypes.contains(typename)) {
            return true;

            // adding type declaration

        }
        try {
            TipoLA type = TipoLA.valueOf(typename.toUpperCase());
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    public static TipoLA getType(String typename) {
        // adding pointer support
        if (typename.charAt(0) == '^') {
            typename = typename.replace("^", "");
            TipoLA aux = TipoLA.valueOf(typename.toUpperCase());
            if (aux == TipoLA.INVALIDO)
                return TipoLA.INVALIDO;
            else
                return TipoLA.PONTEIRO;
        } else if (typename.startsWith("registro") && typename.endsWith("fim_registro")) {
            return TipoLA.REGISTRO;
        } else if (customTypes.contains(typename)){
            return TipoLA.REGISTRO;
        }
//            typename = typename.replace("^", "");

        // preliminar type
        return TipoLA.valueOf(typename.toUpperCase());
    }

    public static TipoLA verifyTypeEquality (TipoLA lt, TipoLA rt) {
        // DEBUG:
        //System.out.println("Equality: "+lt+" : "+rt);
        if (lt == rt) {
            return lt;
        } else if (lt == TipoLA.INTEIRO && rt == TipoLA.REAL ||
            lt == TipoLA.REAL && rt == TipoLA.INTEIRO) {
            return TipoLA.REAL;
        }
        return TipoLA.INVALIDO;
    }

    //
//    public void RegisterListAdd (String var) {
//        registerVariables.add(var);
//    }
//
//    public boolean RegisterListCheck (String var) {
//        if (registerVariables.contains(var)) {
//            registerVariables.remove(var);
//            return true;
//        }
//        return false;
//    }

    // Register associated
    public void addRegister (String r) {
        registers.add(r);
    }

    public void addRegisterVariable (String nr, String nv, TipoLA t) {
        Symble s;
        s = tabela.get(nr);

        s.register.addVariable(nv, t);
    }


    public List<String> getRegisters () {
        Symble reg;

        return registers;
    }

    public void clearRegisters () {
        registers.clear();
    }

//    public boolean isRegisterChild(String v) {
//        // divide between father and child
//        Matcher m = Pattern.compile("^(?:.*?\\.)?(.*?)\\.(.*?)$").matcher(v);
////        if (m.find()) {
////            System.out.println("FatChil: "+ m.group(2)+ " : "+m.group(1)+ " : "+this.isChildOf(m.group(1)));
////            if (this.existe(m.group(2)) && this.isChildOf(m.group(1)) == m.group(2)) {
////                System.out.println("FatChil: "+ m.group(2)+ " : "+m.group(1));
////                return true;
////            }
////        }
//
//
//        return false;
//    }

    // Register counter
    public void increseRegisterCounter() {
        registerCounter += 2;
    }

    public void decreseRegisterCounter() {
        registerCounter -= 1;
    }

    public Integer getRegisterCounter() {
        return registerCounter;
    }

    // Function functions

    public void addFunctionParameter (String nf, String np, TipoLA t) {
        Symble s;
        s = tabela.get(nf);

        s.func.addParameter(np, t);
    }

}
