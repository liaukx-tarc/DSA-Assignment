/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MemberMaintenance;

import java.util.Comparator;

/**
 *
 * @author kaiel
 */
public class MergeSort<T> {
    private final Comparator<T> comparator;
    public MergeSort(Comparator<T> comparator){
        this.comparator = comparator;
    }
    void merge(T[] tempArray, int firstIndex, int midIndex, int lastIndex)
    {
        int subArray1Size = midIndex - firstIndex + 1;
        int subArray2Size = lastIndex - midIndex;
        T[] subArray1 = (T[]) new Object[subArray1Size];
        T[] subArray2 = (T[]) new Object[subArray2Size];
        int sub1Index;
        int sub2Index;
        int mainIndex = firstIndex;
 
        for (sub1Index = 0; sub1Index < subArray1Size; sub1Index++)
        {
            subArray1[sub1Index] = tempArray[firstIndex + sub1Index];
        }
            
        for (sub2Index = 0; sub2Index < subArray2Size; sub2Index++)
        {
            subArray2[sub2Index] = tempArray[midIndex + 1 + sub2Index];
        }
        
        sub1Index = 0;
        sub2Index = 0;
        
        while (sub1Index < subArray1Size && sub2Index < subArray2Size) 
        {
            if (comparator.compare(subArray1[sub1Index], subArray2[sub2Index]) < 0) 
            {
                tempArray[mainIndex] = subArray1[sub1Index];
                sub1Index++;
            }
            else 
            {
                tempArray[mainIndex] = subArray2[sub2Index];
                sub2Index++;
            }
            mainIndex++;
        }

        while (sub1Index < subArray1Size) 
        {
            tempArray[mainIndex] = subArray1[sub1Index];
            sub1Index++;
            mainIndex++;
        }
 
        while (sub2Index < subArray2Size) 
        {
            tempArray[mainIndex] = subArray2[sub2Index];
            sub2Index++;
            mainIndex++;
        }
    }
 
    void sort(T[] mainArray, int firstIndex, int lastIndex)
    {
        if(comparator != null)
        {
            T[] tempArray = mainArray;
            if (firstIndex < lastIndex) 
            {
                int midIndex =(firstIndex + lastIndex)/2;

                sort(tempArray, firstIndex, midIndex);
                sort(tempArray, midIndex + 1, lastIndex);

                merge(tempArray, firstIndex, midIndex, lastIndex);
            }
            mainArray = tempArray;
        }
    }
}
