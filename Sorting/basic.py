def quickSort(arr, left, right):
    if right - left == 2:
        if arr[left] > arr[right - 1]:
            switch(arr, left, right - 1)
        return
    if right - left <= 1:
        return
    pivot_index = int((left + right) / 2)
    pivot = arr[pivot_index]
    switch(arr, pivot_index, right - 1)
    l_cursor = left
    r_cursor = right - 2
    while (l_cursor < r_cursor):
        while arr[l_cursor] < pivot and l_cursor < r_cursor:
            l_cursor += 1
        while arr[r_cursor] > pivot and l_cursor < r_cursor:
            r_cursor -= 1
        if (l_cursor < r_cursor):
            switch(arr, l_cursor, r_cursor)
    switch(arr, l_cursor, right - 1)
    quickSort(arr, 0, l_cursor)
    quickSort(arr, l_cursor, right)
        
def switch(arr, x, y):
    tmp = arr[x]
    arr[x] = arr[y]
    arr[y] = tmp

def mergeSort(arr):
    if len(arr) == 2:
        if arr[0] > arr[1]:
            switch(arr, 0, 1)
        return arr
    if len(arr) == 1:
        return arr
    middle = int(len(arr) / 2)
    left = mergeSort(arr[:middle])
    right = mergeSort(arr[middle:])
    merged = merge(left, right)
    return merged

def merge(left, right):
    merged_array = []
    l = 0
    r = 0
    while (l < len(left) and r < len(right)):
        if left[l] < right[r]:
            merged_array.append(left[l])
            l += 1
        elif right[r] < left[l]:
            merged_array.append(right[r])
            r += 1
    while l != len(left):
        merged_array.append(left[l])
        l += 1
    while r != len(right):
        merged_array.append(right[r])
        r += 1
    return merged_array

    

def main():
    arr = [5, 6, 2, 7, 1, 3, 4, 0]
    arr = mergeSort(arr)
    print(arr)

if __name__ == "__main__":
    main()