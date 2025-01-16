## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

## ##############################################################################################################################

## README - Árboles Binarios

## Descripción

Este proyecto implementa una serie de ejercicios relacionados con la manipulación de árboles binarios en Java. Cada ejercicio demuestra una operación diferentes que se puede realizar en un árbol binario. El código está organizado en clases que corresponden a cada uno de los ejercicios mencionados en el main y en los archivos correspondientes.

## 1. Ejercicio 1: Inserción en un Árbol Binario de Búsqueda
## Descripción: Este ejercicio muestra cómo insertar valores en un árbol binario de búsqueda (BST) y cómo imprimir la lista de valores y la estructura del árbol.

Funcionamiento:

Se insertan los valores de un arreglo en un árbol binario de búsqueda, verificando que en el subárbol izquierdo estén los valores menores y en el subárbol derecho los valores mayores.
El árbol se imprime por niveles para visualizar su estructura.
Clases principales:

InsertBSTTest: Maneja la inserción y la impresión del árbol por niveles y el orden de inserción.

## 2. Ejercicio 2: Inversión de un Árbol Binario
## Descripción: Este ejercicio invierte un árbol binario, intercambiando los nodos de los subárboles izquierdo y derecho de cada nodo.

Funcionamiento:

Se inserta una serie de valores en un árbol binario y luego se invierte la estructura del árbol.
El árbol original y el árbol invertido se imprimen para visualizar el cambio.
Clases principales:

InvertBinaryTree: Maneja la inserción de los valores y la inversión del árbol de manera recursiva.

## 3. Ejercicio 3: Listado de Niveles de un Árbol Binario
## Descripción: Este ejercicio lista todos los nodos del árbol binario, agrupados por niveles.

Funcionamiento:

Después de insertar los valores en el árbol binario, se agrupan los nodos en listas correspondientes a cada nivel del árbol.
Cada nivel del árbol se imprime con los nodos correspondientes.
Clases principales:

ListLevels: Agrupa y devuelve los nodos por niveles usando un recorrido de anchura (BFS).

## 4. Ejercicio 4: Cálculo de la Profundidad de un Árbol Binario
## Descripción: Este ejercicio calcula la profundidad máxima de un árbol binario, es decir, la longitud del camino más largo desde la raíz hasta una hoja.

Funcionamiento:

Se inserta una serie de valores en un árbol binario y se calcula la profundidad máxima.
La profundidad máxima se imprime.
Clases principales:

Depth: Calcula la profundidad máxima utilizando un algoritmo recursivo.

Resumen del cálculo:

Profundidad del nodo 1: 1 (hoja).
Profundidad del nodo 3: 1 (hoja).
Profundidad del nodo 2: 2 (nodo 2 + subárboles 1 y 3).
Profundidad del nodo 8: 1 (hoja).
Profundidad del nodo 7: 2 (nodo 7 + subárbol 8).
Profundidad de la raíz (4): 3 (nodo 4 + subárboles 2 y 7).

Por lo tanto, la profundidad del árbol es 3.

## Cómo Ejecutar el Código
Para ejecutar este proyecto, simplemente ejecuta el main de la clase App, que llama a los métodos correspondientes de cada ejercicio.

## Requisitos
Java 11 o superior.
IDE de tu preferencia (por ejemplo, IntelliJ IDEA, Eclipse, etc.) o puedes compilar y ejecutar desde la línea de comandos.

##  
El metodo public void insert y print tree se ocuparon el los 4 ejercicios.