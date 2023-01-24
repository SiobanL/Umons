"""
    This module use umage lib and contains three function:
        -greyscale
        -greyscale2
        -convolution
        -sobel
"""
import umage as uImg
from math import sqrt as sq


def myCopy(list:list)-> list:
    """create a deepcopy of a list

    Args:
        list (list): list to copy

    Returns:
        list: return other list without no link
    """
    newImgList = []
    for row in list:
        res_row = []
        for element in row:
            res_row.append(element)
        newImgList.append(res_row)
    return newImgList


def greyscale(mat_img: list)-> list:
    """create a new list apply greyscale level filter and use element system in for

    Args:
        mat_img (list): matrix of image who contains a tuple for RGB

    Returns:
        list: new matrix whith greyscale is apply
    """
    greyRes = []
    for row in mat_img:
        res_row = []
        for r,g,b in row:
            res_row.append((int(0.2125 * r + 0.7154 * g + 0.0721 * b),)*3)
        greyRes.append(res_row)             
    return greyRes


def greyscale2(mat_img: list)-> list:
    """generate a new list for apply greyscale level filter and use the position in for

    Args:
        mat_img (list): matrix of image who contains a tuple for RGB

    Returns:
        list: new matrix whith greyscale is apply
    """
    greyRes = []
    for i in range(0,len(mat_img)):
        res_row = []
        for j in range(0,len(mat_img[i])):
            res_row.append((int(0.2125 * mat_img[i][j][0] + 0.7154* mat_img[i][j][1] + 0.0721 * mat_img[i][j][2]),)*3)
        greyRes.append(res_row)
    return greyRes


def convolution(mat_img: list, mat: list)-> list:
    """generate a new list for apply convolution filter

    Args:
        mat_img (list): image matrix
        mat (list): convolution matrix must be absolutely 3x3

    Returns:
        list: new image matrix with convolution apply
    """
    convImg = myCopy(mat_img)
    for i in range(0,len(mat_img)):                     # for every row in image matrix
        for j in range(0,len(mat_img[i])):              # for every tuple of rgb in a line in image matrix
            r, g, b = 0,0,0
            for k in range(0,len(mat)):                 # for every position of a tuple in mat_img, check for all the elements around in 3x3 matrix call mat
                for l in range(0,len(mat[k])):          # for all elements arround add new rgb data in newImg by the folowing formula: r,g,b += element arround by matrix of convolution (for modify the image) but if element arround is out of rage multiply by 0 and add this
                    r += mat[k][l] * mat_img[i-1+k][j-1+l][0] if (0 <= i-1+k < len(mat_img) and 0 <= j-1+l < len(mat_img[i])) else 0
                    g += mat[k][l] * mat_img[i-1+k][j-1+l][1] if (0 <= i-1+k < len(mat_img) and 0 <= j-1+l < len(mat_img[i])) else 0
                    b += mat[k][l] * mat_img[i-1+k][j-1+l][2] if (0 <= i-1+k < len(mat_img) and 0 <= j-1+l < len(mat_img[i])) else 0
            convImg[i][j] = ((min(max(int(r),0),255), min(max(int(g),0),255), min(max(int(b),0),255))) # cap r,g,b between 0 to 255 for rgb data format
    return convImg


def sobel(mat_img:list)-> list:
    """generate a new list for apply sobel filter on image

        Sobel filter need to apply two gradients. First is
        x and second is y gradient:
            - x = [1,2,1]x[-1,0,+1]
            - y = [-1,0,+1]x[1,2,1]
        To get the gradients, we apply two convolutions on
        image matrix with x and y. After we do the norm so 
        sqrt((gx²+gy²))

    Args:
        mat_img (list): image matrix

    Returns:
        list: image matrix with sobel filter applied
    """
    gx = convolution(mat_img,[[-1,0,1],[-2,0,2],[-1,0,1]])
    gy = convolution(mat_img,[[-1,-2,-1],[0,0,0],[1,2,1]])
    sobelFilterImg = myCopy(mat_img)
    for i in range(0,len(mat_img)):
        for j in range(0,len(mat_img[i])):
            sobelFilterImg[i][j] = (int(sq((gx[i][j][0]**2+gy[i][j][0]**2))), int(sq((gx[i][j][1]**2+gy[i][j][1]**2))), int(sq((gx[i][j][2]**2+gy[i][j][2]**2))))
    return sobelFilterImg


# def circle(img, center: tuple, radius, color):
#     cx, cy = center
#     for i in range(len(img)):
#         for j in range(len(img[i])):
#             # len(img)//2 len(img[i]//2)+radius color 1 case
#             # len(img)//2 len(img[i]//2)+radius-1 color 3 case
#             # radius == midle Pos
            
#     return


def main()-> None:
    filename = 'imgTest/Sans titre.png'
    matrix_image = uImg.load(filename)
    print(matrix_image)
    circle(matrix_image, (len(matrix_image/2)(len(matrix_image[0])/2),5,(000,000,000)))
    uImg.save(greyscale(matrix_image),"imgResult/image_testRG1","jpg")
    uImg.save(greyscale2(matrix_image),"imgResult/image_testRG2","jpg")
    
    convFirt =   [
                  [-1,-1,-1],
                  [-1,8,-1 ],
                  [-1,-1,-1]
                 ]
    convSecond = [
                  [-1,-1,-1],
                  [-1,9,-1 ],
                  [-1,-1,-1]
                 ]
    convThrid =  [
                  [-2,0,0],
                  [0,1,0 ],
                  [0,0,2 ]
                 ]
    
    uImg.save(convolution(matrix_image, convFirt),'imgResult/image_testConvF',"jpg")
    uImg.save(convolution(matrix_image, convSecond),'imgResult/image_testConvS',"jpg")
    uImg.save(convolution(matrix_image, convThrid),'imgResult/image_testConvT',"jpg")
    
    uImg.save(sobel(matrix_image),"imgResult/image_testSobel","jpg")


main()

