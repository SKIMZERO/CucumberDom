package Documentation;

public class ArchivoTexto {

    private String description;
    private String expected;

    public ArchivoTexto(String description, String expected){
        this.description = description;
        this.expected = expected;
    }

    public String getDescription() {
        return this.description;
    } 

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExpected() {
        return this.expected;
    }

    public void setExpected(String expected) {
        this.expected = expected;
    }

}
