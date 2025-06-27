package user;

import mainPackage.App;

public class PermanentE extends User{

    public PermanentE(String name, App system) {
        super(name, system);
        this.state = new PermanentExpert();
    }
}
