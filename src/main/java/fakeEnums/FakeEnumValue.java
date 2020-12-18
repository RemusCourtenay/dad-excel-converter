package fakeEnums;

public abstract class FakeEnumValue{

    private final String name;

    public FakeEnumValue(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
