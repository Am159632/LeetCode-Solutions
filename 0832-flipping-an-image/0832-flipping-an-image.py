import numpy

class Solution:
    def flipAndInvertImage1(self, image: List[List[int]]) -> List[List[int]]:
        for i in range(len(image)):
            image[i].reverse()
            for j in range(len(image[i])):
                if image[i][j]==0: image[i][j]=1
                elif image[i][j]==1: image[i][j]=0
        return image

    def flipAndInvertImage(self, image: List[List[int]]) -> List[List[int]]:
        arr = numpy.array(image)
        arr = arr[:, ::-1]
        arr=1-arr
        return arr.tolist()


        