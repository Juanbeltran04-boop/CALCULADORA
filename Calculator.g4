grammar Calculator;

options { visitor = true; } 

prog:   stat+ ;

stat:   expr NEWLINE
    |   'print' expr NEWLINE
    ;

expr:   expr ('+'|'-') expr
    |   expr ('*'|'/') expr
    |   '(' expr ')'
    |   INT
    ;

INT:    [0-9]+ ;
NEWLINE: '\r'? '\n' ;

WS: [ \t]+ -> skip ; // Ignorar espacios en blanco


