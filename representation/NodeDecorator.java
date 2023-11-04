package representation;

public abstract class NodeDecorator implements Event{
    private final Event wrapped;
    private final Node node;

    public NodeDecorator(Event wrapped , Node node){
        this.wrapped = wrapped;
        this.node = node;
    }

    @Override
    public void display(){
        wrapped.display();
    }

    @Override
    public Displayable chooseNext(){
        wrapped.chooseNext();
    }
}
