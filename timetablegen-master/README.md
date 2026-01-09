# Time-Table-Generator
 Timetable Generator using Genetic Algorithm
Introduction

Creating an academic timetable manually is a difficult and time-consuming task, especially when there are multiple subjects, teachers, classrooms, and student batches. It also becomes hard to satisfy all constraints like minimum subject hours and lab sessions.

This project is a Java-based Timetable Generator that uses a Genetic Algorithm to automatically generate a valid timetable by handling these constraints efficiently.

Objective

The main goal of this project is to:

Automate the timetable generation process

Reduce manual effort and human errors

Generate a readable timetable for multiple student groups

Understand and apply Genetic Algorithms to a real-world problem

Why Genetic Algorithm?

Timetable scheduling is a constraint-based optimization problem.
Instead of checking all possible combinations (which is inefficient), a Genetic Algorithm helps in:

Generating multiple possible solutions

Improving solutions step by step

Reaching an acceptable timetable within reasonable time

This approach is suitable for problems where traditional methods are complex or slow.

How the System Works

Each timetable is treated as a chromosome

Each lecture slot is treated as a gene

An initial population of timetables is generated

Fitness is calculated based on constraints like:

Subject hour requirements

Valid teacher and classroom assignment

Better timetables are selected and evolved over generations
