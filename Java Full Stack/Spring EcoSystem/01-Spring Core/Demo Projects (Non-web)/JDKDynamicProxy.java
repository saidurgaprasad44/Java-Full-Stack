package demo.example.jdk_dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Hello world!
 *
 */
public class JDKDynamicProxy 
{
    public static void main( String[] args ) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
    	PaymentService paymentService = new PaymentServiceImpl();
    	OrderService orderService = new OrderServiceImpl();
//        PaymentService paymentProxy = new PaymentServiceStaticProxy(service);
    	OrderService orderProxy = (OrderService) Proxy.newProxyInstance(
    			orderService.getClass().getClassLoader(),
    			orderService.getClass().getInterfaces(),
    			new LoggingHandler(orderService));
    	
    	orderProxy.placeOrder();
    	System.out.println();
    	
        PaymentService paymentProxy = (PaymentService) Proxy.newProxyInstance(
        		paymentService.getClass().getClassLoader(),
        		paymentService.getClass().getInterfaces(),
        		new LoggingHandler(paymentService));
        
        paymentProxy.processPayment();

    	
    }
}


interface PaymentService {
	public void processPayment();
}


class PaymentServiceImpl implements PaymentService {

	@Override
	public void processPayment() {
		System.out.println("Processing payment...");
	}

}


class PaymentServiceStaticProxy implements PaymentService{
	PaymentService service;
	
	public PaymentServiceStaticProxy(PaymentService service) {
		this.service = service;
	}
	
	@Override
	public void processPayment() {
		System.out.println("log before...");
		service.processPayment();
		System.out.println("log after...");
	}

}

class LoggingHandler implements InvocationHandler {
	private Object target;
	
	public LoggingHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("logging before...");
		Object result = method.invoke(target, args);
		System.out.println("logging after...");
		return result;
	}
	
	
}

interface OrderService {
	public void placeOrder();
}

class OrderServiceImpl implements OrderService {
	
	@Override
	public void placeOrder() {
		System.out.println("Placing an order...");
	}
}

