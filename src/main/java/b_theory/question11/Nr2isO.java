package b_theory.question11;

public class Nr2isO {

    //todo this is a contribution based question so make sure to keep commits separate
    //todo A What does O stand for in SOLID? Explain the principle.
    //The 0 stands for Open-closed principle. It means that you should be able to add new functionality to the code without
    //rewriting the existing code
    //todo B Give an example. Write actual or pseudo code.

}
class drawShape {
        public void draw(Shape s) {
            s.draw();
        }
}

class Shape {
        public void draw(){
            //draw shape
        }
}

class drawCircle extends Shape{
        public void draw() {
            // draw the circle
        }
}
