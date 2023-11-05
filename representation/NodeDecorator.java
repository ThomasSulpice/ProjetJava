package representation;

public abstract class NodeDecorator implements Event{
    protected final Event wrapped;
    protected Event node;

    public NodeDecorator(Event wrapped , Event node){
        this.wrapped = wrapped;
        this.node = node;
    }

    @Override
    public void display(){
        wrapped.display();
    }

    @Override
    public Event chooseNext(){
        return node.chooseNext();
    }
}
