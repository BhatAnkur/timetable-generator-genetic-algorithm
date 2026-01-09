# Time-Table-Generator  
**Timetable Generator using Genetic Algorithm**

---

## Introduction

Creating an academic timetable manually is a difficult and time-consuming task, especially when there are multiple subjects, teachers, classrooms, and student batches. It also becomes hard to satisfy all constraints like minimum subject hours and lab sessions.

This project is a **Java-based Timetable Generator** that uses a **Genetic Algorithm** to automatically generate a valid timetable by handling these constraints efficiently.

---

## Objective

The main goal of this project is to:

1. Automate the timetable generation process  
2. Reduce manual effort and human errors  
3. Generate a readable timetable for multiple student groups  
4. Understand and apply Genetic Algorithms to a real-world problem  

---

## Why Genetic Algorithm?

Timetable scheduling is a **constraint-based optimization problem**.  
Instead of checking all possible combinations (which is inefficient), a Genetic Algorithm helps in:

1. Generating multiple possible solutions  
2. Improving solutions step by step  
3. Reaching an acceptable timetable within reasonable time  

This approach is suitable for problems where traditional methods are complex or slow.

---

## How the System Works

1. Each timetable is treated as a **chromosome**  
2. Each lecture slot is treated as a **gene**  
3. An initial population of timetables is generated  
4. Fitness is calculated based on constraints like:  
   - Subject hour requirements  
   - Valid teacher and classroom assignment  
5. Better timetables are selected and evolved over generations  

---
