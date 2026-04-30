	DECLARE
	a NUMBER;
	b NUMBER;
	BEGIN
	a := &a;
	b := &b;
	if  (a>b)then
		DBMS_OUTPUT.PUT_LINE(' a is greater');
	else
		DBMS_OUTPUT.PUT_LINE('b is greater');
	end if;
	END;
/

