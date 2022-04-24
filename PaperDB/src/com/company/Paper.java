package com.company;
import java.util.Objects;
//Hier befindet sich alles rundum Referenzen + Graph
class ReferenceArrayList{
        Paper[] data;
        int size=0;
    }
    public class Paper {
         PaperDB reference_ID;

        public static Paper create(PaperDB reference_ID){
             Paper ra = new Paper();
             ra.reference_ID=reference_ID;
             return ra;
         }
        public static void addReference(PaperList paplist, int idx,int Referenzierter) {
            PaperDB paper =Objects.requireNonNull(PaperDBLogik.get(paplist, idx)).data;

            if(paper==null||PaperDBLogik.get(paplist, idx)==null){
                 System.out.print("");
            }else {
                if (paper.Referenzen == null) {
                        paper.Referenzen = new ReferenceArrayList();
                        paper.Referenzen.data=new Paper[1];
                        paper.Referenzen.data[0]=create(Objects.requireNonNull(PaperDBLogik.get(paplist, Referenzierter)).data);
                        paper.Referenzen.size+= 1;
                }
                else{
                    resize(paper.Referenzen, paper.Referenzen.data.length +1);
                    paper.Referenzen.size+= 1;
                    paper.Referenzen.data[paper.Referenzen.data.length-1]= create(Objects.requireNonNull(PaperDBLogik.get(paplist, Referenzierter)).data);

                    sort(paper.Referenzen.data);//wird immer nach Autor sortiert
                }

            }
        }//Referenzen adden
        private static void resize(ReferenceArrayList list, int size) {
            Paper[] arr = new Paper[size];
            System.arraycopy(list.data, 0, arr, 0, list.data.length);
            list.data = arr;
        }//Addsize
        public static void RefPrint(PaperList list) {
            int counterRef = 0;
            PaperDBLogik.printUnderline(75);

            System.out.printf("%25s| %25s\n", "Referenziert      ", "Referenzierter     ");
            PaperDBLogik.printUnderline(75);

            for (int i = 0; i < list.size; i++) {
                PaperDB paper =Objects.requireNonNull(PaperDBLogik.get(list, i)).data;
                if(paper.Referenzen ==null) {
                    System.out.print("");
                }
                else {
                    for(int j = 0; j< paper.Referenzen.data.length; j++) {
                            System.out.printf("%-3d| %10s%s -> %s%s  \n", counterRef, paper.Autor, paper.Datum.year,
                                    paper.Referenzen.data[j].reference_ID.Autor, paper.Referenzen.data[j].reference_ID.Datum.year);
                            counterRef++;
                        }
                }
            }
            System.out.println();
            PaperDBLogik.printUnderline(75);

            System.out.printf("%d Referenz(en)!\n", counterRef);
            PaperDBLogik.printUnderline(75);
        }// den Graphen ausgeben
        public static boolean compare(PaperList list, int x, int y){
            for(int i=0;i<list.size;i++) {
                PaperDB paper =Objects.requireNonNull(PaperDBLogik.get(list, i)).data;
                if (paper.Referenzen == null) {
                    System.out.print("");
                } else {
                    for (int j = 0; j < paper.Referenzen.data.length; j++) {
                        if (x == i && Objects.requireNonNull(PaperDBLogik.get(list, y)).data == paper.Referenzen.data[j].reference_ID) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }//Überprüft, ob eine Referenz schon vorhanden ist

        //MergeSort um die Arrays zu sortieren__nur nach Autor__ASCII Tabelle(char_Wert)_toUpperCase==> klein a == groß a, sonst ASCII_konform
        private static void sort(Paper[] elements) {
            int length = elements.length;
            Paper[] sorted = mergeSort(elements, 0, length - 1);
            System.arraycopy(sorted, 0, elements, 0, length);
        }//Hier wird ein neues Paper[] sortiert und diese Werte werden dem unsortierten Array übermittelt
        private static Paper[] mergeSort(Paper[] elements, int links, int rechts) {

            if (links == rechts){
                return new Paper[]{elements[links]};
            }

            int mitte = links + (rechts - links) / 2;
            Paper[] leftArray = mergeSort(elements, links, mitte);
            Paper[] rightArray = mergeSort(elements, mitte + 1, rechts);
            return merge(leftArray, rightArray);
        }//Hier wird Array in kleine Bereiche geschnitten, zum schluss auf die Zusammenfügen-Methode verwiesen
        private static Paper[] merge(Paper[] leftArray, Paper[] rightArray) {
            int leftLen = leftArray.length;
            int rightLen = rightArray.length;

            Paper[] target = new Paper[leftLen + rightLen];
            int targetPos = 0;
            int leftPos = 0;
            int rightPos = 0;


            while (leftPos < leftLen && rightPos < rightLen) {

                char leftValue = leftArray[leftPos].reference_ID.Autor.toUpperCase().charAt(0);
                char rightValue = rightArray[rightPos].reference_ID.Autor.toUpperCase().charAt(0);
                if (leftValue <= rightValue) {
                    target[targetPos++] = leftArray[leftPos];
                    leftPos++;
                } else {
                    target[targetPos++] = rightArray[rightPos];
                    rightPos++;
                }
            }

            while (leftPos < leftLen) {
                target[targetPos++] = leftArray[leftPos++];
            }
            while (rightPos < rightLen) {
                target[targetPos++] = rightArray[rightPos++];
            }
            return target;
        }//Hier werden die Werte zu einem Array sortiert zusammengefügt

         /*digraph G {

        subgraph cluster_1 {
            style=filled;
            color=lightblue;
            node [style=filled,color=white];
            Brunnbauer2014 -> Cerny2020
            Brunnbauer2014 -> Demetz1990
            Brunnbauer2014 -> Hösel1990
            Brunnbauer2014 -> Mandl2018
            Brunnbauer2014 -> Satek2004
            Brunnbauer2004 -> Satek2004
            Hösel1990 -> Brunnbauer2014
            Hösel1990 -> Cerny2020
            Cerny2020 -> Brunnbauer2014
            Mandl2018 -> Brunnbauer2014
            Satek2004 -> Brunnbauer2014
            Satek2004 -> Cerny2020
            Satek2004 -> Hösel1990
            Demetz1990 -> Brunnbauer2014
            Demetz1990 -> Cerny2020
            Kelmendi2022 -> Brunnbauer2004
            Kelmendi2022 -> Demetz1990
            Kelmendi2022 -> Hösel1990
            Kelmendi2022 -> Mandl2018
            Kelmendi2022 -> Satek2004
            label = "Referenzen";
        }

    }*/ //Testdaten_Graph (graphviz.png)
    }

