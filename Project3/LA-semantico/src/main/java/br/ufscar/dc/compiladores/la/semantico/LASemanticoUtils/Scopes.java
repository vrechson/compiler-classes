/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.compiladores.la.semantico.LASemanticoUtils;

import java.util.LinkedList;
import java.util.List;

public class Scopes {
    private LinkedList<SymbleTable> tableStack;
    
    public Scopes() {

        // Each scope must create its own tableStack
        tableStack = new LinkedList<>();
        createNewScope();
    }

    // Scope management

    // Create new scope
    public void createNewScope() {
        tableStack.push(new SymbleTable());
    }

    // Get the currently working context
    public SymbleTable getCurrentContext() {
        return tableStack.peek();
    }

    // I don't know why this function is needed, may delete it in the future
    // Maybe for debug and error reasons
    public List<SymbleTable> walkNestedContext() {
        return tableStack;
    }

    public void removeContext() { tableStack.pop();}

    public int getContextLevel() { return tableStack.size();}

    // Working context utils

    // Check if a variable exists localy
    public boolean existsInCurrentScope(String v) {
        SymbleTable curr = this.getCurrentContext();
        return curr.existe(v);
    }

    // Get a local variable type
    public SymbleTable.TipoLA getSymbolType(String v) {
        SymbleTable curr = this.getCurrentContext();
        return curr.verificar(v);
    }


    // Add a local variable
    public void addSymbol(String n, SymbleTable.TipoLA t) {
        SymbleTable curr = this.getCurrentContext();
        curr.addSymbol(n, t);
    }

    // Add a local pointer
    public void addSymbol(String n, SymbleTable.TipoLA t, SymbleTable.TipoLA s) {
        SymbleTable curr = this.getCurrentContext();
        curr.addSymbol(n, t, s);
    }

    // Add a new type
    public void registerType(String n, SymbleTable.TipoLA t) {
        SymbleTable curr = this.getCurrentContext();
        curr.registerType(n, t);
    }

    public void instanceType(String n, String t) {
        SymbleTable curr = this.getCurrentContext();
        curr.instanceType(n, t);
    }

    // Add a local register
    // TODO: this may change
//    public void addSymbol(String n, SymbleTable.TipoLA t, String s) {
//        SymbleTable curr = this.getCurrentContext();
//        curr.addSymbol(n, t, s);
//    }

    // Register associated functions
    // TODO: clean all this mess

    // add a register
    public void addRegisterVariable(String nr, String nv, SymbleTable.TipoLA t) {
        SymbleTable curr = this.getCurrentContext();
        curr.addRegisterVariable(nr, nv, t);
    }

    public boolean existsInRegisterList(String v) {
        SymbleTable curr = this.getCurrentContext();
        //return curr.RegisterListCheck(v);
        return true;
    }

    public void addRegister(String r) {
        SymbleTable curr = this.getCurrentContext();
        curr.addRegister(r);
    }

    public List<String> getRegisters() {
        SymbleTable curr = this.getCurrentContext();
        return curr.getRegisters();
    }

    public void cleanRegisters() {
        SymbleTable curr = this.getCurrentContext();
        curr.clearRegisters();
    }

//    public boolean registerChild(String v) {
//        SymbleTable curr = this.getCurrentContext();
//        return curr.isRegisterChild(v);
//    }

    public void increseRegisterCounter() {
        SymbleTable curr = this.getCurrentContext();
        // DEBUG:
        //System.out.println("increasing register count");
        curr.increseRegisterCounter();
    }

    public void decreaseRegisterCounter() {
        SymbleTable curr = this.getCurrentContext();
        curr.decreseRegisterCounter();
    }

    public Integer getRegisterCounter() {
        SymbleTable curr = this.getCurrentContext();
        return curr.getRegisterCounter();
    }

    // Functions

    // add a register
    public void addFunctionParameter(String nf, String np, SymbleTable.TipoLA t) {
        SymbleTable curr = this.getCurrentContext();
        curr.addFunctionParameter(nf, np, t);
    }

}
