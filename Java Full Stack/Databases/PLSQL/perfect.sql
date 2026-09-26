DECLARE
n NUMBER;
m NUMBER;
i NUMBER:=1;
c NUMBER:=0;
f NUMBER;
j NUMBER;

BEGIN
n:='&n';
m:=n;
j:=FLOOR(n/2);
while(i<=j)
loop
f:=mod(n,i);
if(f=0)
then
c:=c+i;
end if;
i:=i+1;
end loop;
if(m=c) then
DBMS_OUTPUT.PUT_LINE('PERFECT NUMBER');
else
DBMS_OUTPUT.PUT_LINE('NOT A PERFECT NUMBER');
end if;
END;
/
