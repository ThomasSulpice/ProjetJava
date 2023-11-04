package representation;

public abstract class NodeDecorator implements Event{
    protected final Event wrapped;
    protected final Node node;

    public NodeDecorator(Event wrapped , Node node){
        this.wrapped = wrapped;
        this.node = node;
    }

    @Override
    public void display(){
        wrapped.display();
    }

    @Override
    public Node chooseNext(){
        return node.chooseNext();
    }
}
