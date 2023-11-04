package representation;

public class SoundNode extends NodeDecorator{

    /*** ajouter un attribut sound qui sera utilisé dans display et l'ajouter au constructeur
     */


    public SoundNode(Event wrapped , Node node){
        super(wrapped , node);
    }

    @Override
    public void display(){
        super.display();
        /*** jouer le son
         */
    }
}
