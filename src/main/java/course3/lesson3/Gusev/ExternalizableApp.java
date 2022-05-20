package course3.lesson3.Gusev;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ExternalizableApp {
}

class Dog implements Externalizable {

    private String name;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject("name" + name.toUpperCase());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }
}
