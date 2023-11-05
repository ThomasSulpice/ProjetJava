package representation;

public class ImageNode extends NodeDecorator{

    /*** ajouter un attribut image qui sera utilisé dans display
     */


    public ImageNode(Event wrapped , Node node){
        super(wrapped , node);
    }

    @Override
    public void display(){
        super.display();
        /*** afficher l'image
         */
    }

}
