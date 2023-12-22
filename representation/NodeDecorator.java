package representation;

/** NodeDecorator implémente l'interface Event.
 * NodeDecorator, ainsi que Event, correspondent à l'implémentation d'un pattern design Decorator,
 * permettant à n'importe quel noeud d'une sous classe de Node d'aussi afficher une image ou jouer un son
 * lors de l'utilisation de la méthode display.
 * @author Thomas Sulpice
 */
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
