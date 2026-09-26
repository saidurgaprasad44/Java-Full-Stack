

DECLARE
num1 number(5); 
num2 number(5);
rev number(5);

BEGIN
num1:=&num1;
rev:=0;
while (num1>0)
loop
num2:=mod(num1,10);
rev:=num2+(rev*10);
num1:=floor(num1/10);
end loop;
DBMS_OUTPUT.PUT_LINE('reverse num is '||rev);
end;
/

