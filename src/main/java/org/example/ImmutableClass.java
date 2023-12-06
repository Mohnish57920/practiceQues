package org.example;

public final class ImmutableClass {

    private String id;

    public ImmutableClass(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

}
