# COMP2000-Object-Oriented-programming-assignment-code-base

This will be a basic life simualtion using OO programing practices.


### RUNNING PROGRAM
To run the code first run:
1. cd SourceCode
2. mkdir -p out
3. javac -d out $(find . -name '*.java')
4. java -cp out main


### What it Represents
there are four classes; sheep, wolf, shurb, tree. each are classified and built by the Animal or Plant abstract classes. The simulation spawns entities at random times, when a wolf is spawned it will move towards the nearest sheep, when a sheep is spawned it will move towards the nearest shrub.  

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

#### Sheep and Wolf Behaviour
SheepBehaviour defines and controls the functionality set by the Animal superclass. In the variable and functions <strong>target</strong> refers to:
sheep in the wolf class and shurb in the sheep class.

Variables: 
- sheep/wolf: defines the current instance of the sheep or wolf
- closestShrub/closestSheep: holds the object value of the closest target
- closestDistance: holds the X and Y of the closest target
- stepX: moves the instance across the X pane of the grid
- stepY: moves the instance across the Y pane of the grid

Functions (Act): 
- 'searching': A for loop that checks all instances currently on the grid to find the closest target based on its X and Y reduced by the sheeps or wolfs current X and Y
- 'hunt': When the closestShrub variable contains an object the stepX and stepY varaibles will increment or decrement until the instances closestDistance value is equal to 1 where the target will be destroyed 

### Plant

Plant is the superclass for Shrub and Tree, it contains a base template that pulls functions from its Entitiy superclass. 

Variables:
- growth: acts as the lifetime for the plant subclasses 

Functions:
- Plant: constuctor for the instance 
- getGrowth: retruns the instances growth count
- grow: depreciated function that would have been implimented in the tree class to make it cover more square in the grid

#### Shrub
The shrub is a entitiy that is a target for the sheep class and if it reaches 25 on its growth it gets destroyed and a tree is created in its place. 

Unique fucntions: 
- (@Override)getColour: used for the JPanel display 

#### Tree
The tree is the only entitiy that is not spawned in randomly, the only way it is created is when a shrub reaches 25 on its growth variable.

Unique fucntions:   
- (@Override)getColour: used for the JPanel display 
