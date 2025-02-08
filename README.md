# KeepTrivial

KeepTrivial is a basic CLI version of Trivial written in Java for KeepCoding's 4th Java Bootcamp.

## Purpose

My purpose with this app was to put in practice some of the concepts seen during the JavaFromZero module or, in other words, the goal was not directed towards writing the most efficient app.

## Design Pattern

Following this idea, I spent some time thinking on and implementing a pattern design that could work for CLI projects of any scale. I call it Model-CLI-Controller (MCC).

### CLI and views

The main difference between this one and MVC lies on the fact that CLI classes are just in charge of the user interaction or I/O through the console. Ideally CLI could work just as a view,
by buffering certain inputs and triggering and event when a concrete operation is finished (maybe for v2.0). However, here CLI classes only serve the controllers which manage all the logic that would
belong to views.

### Controllers

A part from integrating views' logic, controllers also manage some of the logic that could belong to models, as we can see in TrivialController. Nonetheless, I consider a controller as a way of putting
together all the related models (e.g.: Trivial, Team and Question in TrivialController) and using just a single CLI class to show results and ask the user for data (e.g.: CLITrivial in TrivialController).

### Models

Meanwhile, models tend to include only logic related to themselves or their attributes. That is why, for example, the Trivial Model manages teams and questions, while these ones only work
with themselves.

## Configuration

In order to create a game there should be a 'questions' directory at the root of the deployment (as it is included in this repository). Since there are five types of questions, there are five files
containing questions from each type. Files must have the names of the five types:
1. technology.txt
2. programming_history.txt
3. networks.txt
4. ai.txt
5. keepcoding_history.txt

### Why mandatory filenames?

Since Java is a compiled language it cannot generate on runtime certain data structures such as Enum classes. In another kind of language we could read the filenames and set them as entries of a 
dynamically generated enum type. In Java the alternative could be to use a global array containing the filenames and using it every time we need to check the type of the question.
For this basic project, it may not be a big deal, but, for further updates, an Enum class is likely to be way more elegant, clear and easy to use. Additionally, this approach allows us to use generic
datatypes with the QuestionType enum class.

