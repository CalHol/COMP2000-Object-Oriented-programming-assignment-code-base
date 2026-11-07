# COMP2000-Object-Oriented-programming-assignment-code-base

This will be a basic life simualtion using OO programing practices

### What it Represents
there are four classes; sheep, wolf, shurb, tree. each are classified and built by the Animal abstract class or Plant abstract class. 

### Animal

Animal is the base class for Wolf and Sheep and holds the base local variables used in the subclasses as well as definining the function section for development when either a Sheep or Wolf is created.

Variables:
- X: the instances X position on the grid
- Y: the instances Y position on the grid
- Lifetime: A counter to represent how many tick the target has been since instantiated or last eaten
- EatCount: a counter to show how many times the unique instance has eaten
- Behaviour: holds the behaviour function

Functions: 
- Animal: superclass to set variables 
- getLifeTime: gets the current lifetime
- resetLifeTime: resets lifetime after act has has registered an 'eat' action
- getMaximumLifetime: set maximum lifetime to 50
- getEatCount: counter for the ammount of times the instance has eaten 
- incrementEatCount: increments when act has registered an 'eat' action
- act: superclass for the Act behaviour 
- move: superclass for instances X and Y 
- update: updates lifetime as the simulation runs

#### SheepBehaviour
SheepBehaviour defines and controls the functionality set by the Animal superclass 

Variables: 
- sheep: defines the current instance of the sheep
- closestShrub: holds the object value of the closest shrub 
- closestDistance: holds the X and Y of the closes shrub
- stepX: moves the instance across the X pane of the grid
- stepY: moves the instance across the Y pane of the grid

Functions (Act): 
- 'searching': A for loop that checks all instances currently on the grid to find the closest shrub based on its X and Y reduced by the sheeps current X and Y
- 'hunt': When the closestShrub variable contains an object the stepX and stepY varaibles will increment or decrement until the instances closestDistance value is equal to 1 where the shrub will be destroyed 

#### WolfBehaviour
The wolf will move toward the closest sheep, when reaches an adjacent square the sheep will be destroyed, the counter for 'eat' will increment by one, and the isntances lifetime variable will reset.

### Plant

#### Shrub



#### Tree

To run the code first run:
1. cd SourceCode
2. mkdir -p out
3. javac -d out $(find . -name '*.java')
4. java -cp out main