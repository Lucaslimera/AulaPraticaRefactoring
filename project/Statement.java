package project;

import java.util.Enumeration;

public abstract class Statement {

    public String statement(Customer aCustomer) {
        return value(aCustomer);
    }

    public abstract String value(Customer aCustomer);
}
