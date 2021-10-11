import subprocess
import pathlib
import sys

la_path=pathlib.Path(__file__).parent.resolve()

if sys.argv[1] == "exec":
    if sys.argv[2] == "lexical":
        cmd = ['java', '-jar',
        # compiler directory
        str(la_path)+'/Project1/LA-lexico/target/la-lexico-1.0-SNAPSHOT-jar-with-dependencies.jar',
        # input path
        sys.argv[3],
        # output path
        sys.argv[4]
        ]
    elif sys.argv[2] == "syntactical":
        cmd = ['java', '-jar',
        # compiler directory
        str(la_path)+'/Project2/LA-sintatico/target/LA-sintatico-1.0-SNAPSHOT-jar-with-dependencies.jar',
        # input path
        sys.argv[3],
        # output path
        sys.argv[4]
        ]
elif sys.argv[1] == "lexical-tests":
    print("[+] Running lexical tests")
    cmd = ['java', '-jar',
        # binary test path
        str(la_path)+'/compiladores-corretor-automatico/target/compiladores-corretor-automatico-1.0-SNAPSHOT-jar-with-dependencies.jar',
        # compiler directory
        'java -jar '+ str(la_path)+'/Project1/LA-lexico/target/la-lexico-1.0-SNAPSHOT-jar-with-dependencies.jar',
        # gcc compiler ????
        'gcc',
        # temp files
        '/tmp',
        # test cases
        str(la_path)+'/casos-de-teste',
        # RAs
        '727349, 726579',
        # opts
        'lexico'
    ]
elif sys.argv[1] == "syntactical-tests":
    print("[+] Running sintatical tests")
    cmd = ['java', '-jar',
        # binary test path
        str(la_path)+'/compiladores-corretor-automatico/target/compiladores-corretor-automatico-1.0-SNAPSHOT-jar-with-dependencies.jar',
        # compiler directory
        'java -jar '+ str(la_path)+'/Project2/LA-sintatico/target/LA-sintatico-1.0-SNAPSHOT-jar-with-dependencies.jar',
        # gcc compiler ????
        'gcc',
        # temp files
        '/tmp',
        # test cases
        str(la_path)+'/casos-de-teste',
        # RAs
        '727349, 726579',
        # opts
        'sintatico'
    ]
elif sys.argv[1] == "semantical-tests":
    print("[+] Running semantical tests")
    cmd = ['java', '-jar',
        # binary test path
        str(la_path)+'/compiladores-corretor-automatico/target/compiladores-corretor-automatico-1.0-SNAPSHOT-jar-with-dependencies.jar',
        # compiler directory
        'java -jar '+ str(la_path)+'/Project3/LA-semantico/target/LA-semantico-1.0-SNAPSHOT-jar-with-dependencies.jar',
        # gcc compiler ????
        'gcc',
        # temp files
        '/tmp',
        # test cases
        str(la_path)+'/casos-de-teste',
        # RAs
        '727349, 726579',
        # opts
        'semantico'
    ]
elif sys.argv[1] == "generator-tests":
    print("[+] Running generator tests")
    cmd = ['java', '-jar',
        # binary test path
        str(la_path)+'/compiladores-corretor-automatico/target/compiladores-corretor-automatico-1.0-SNAPSHOT-jar-with-dependencies.jar',
        # compiler directory
        'java -jar '+ str(la_path)+'/Project3/LA-semantico/target/LA-semantico-1.0-SNAPSHOT-jar-with-dependencies.jar',
        # gcc compiler ????
        'gcc',
        # temp files
        '/tmp',
        # test cases
        str(la_path)+'/casos-de-teste',
        # RAs
        '727349, 726579',
        # opts
        'gerador'
    ]
elif sys.argv[1] == "all":
    print("[+] Running all tests")
    cmd = ['java', '-jar',
        # binary test path
        str(la_path)+'/compiladores-corretor-automatico/target/compiladores-corretor-automatico-1.0-SNAPSHOT-jar-with-dependencies.jar',
        # compiler directory
        'java -jar '+ str(la_path)+'/Project3/LA-semantico/target/LA-semantico-1.0-SNAPSHOT-jar-with-dependencies.jar',
        # gcc compiler ????
        'gcc',
        # temp files
        '/tmp',
        # test cases
        str(la_path)+'/casos-de-teste',
        # RAs
        '727349, 726579',
        # opts
        'tudo'
    ]
else:
    cmd = ["echo", "thanks for come"]

result = subprocess.run(cmd, stdout=subprocess.PIPE)
print(result.stdout.decode('UTF-8'))