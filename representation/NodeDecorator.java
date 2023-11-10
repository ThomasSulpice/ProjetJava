package representation;

public abstract class NodeDecorator implements Event{
    protected final Event wrapped;

    public NodeDecorator(Event wrapped){
        this.wrapped = wrapped;
    }

    @Override
    public void display(){
        wrapped.display();
    }

    @Override
    public Event chooseNext(){
        return wrapped.chooseNext();
    }
}
