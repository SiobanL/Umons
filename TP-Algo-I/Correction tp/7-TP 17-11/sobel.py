import umage


def greyscale(img):
    new_img = []

    for line in img:
        new_line = []
        for pixel in line:
            R, G, B = pixel
            v = int(0.2125 * R + 0.7154 * G + 0.0721 * B)
            new_line.append((v, v, v))
        new_img.append(new_line)

    return new_img


def greyscale_lambda(img):
    new_img = []

    # Lambda is easier...
    f = (lambda R, G, B: int(0.2125 * R + 0.7154 * G + 0.0721 * B))

    for line in img:
        new_line = []
        for pixel in line:
            new_line.append((f(pixel),) * 3)
        new_img.append(new_line)

    return new_img


def convolution(img, mat):
    msize = len(mat)
    width, height = len(img[0]), len(img)

    # Define a safe getter for img
    def safe_getter(i, j):
        if 0 <= i < height and 0 <= j < width:
            return img[i][j]
        else:
            return (0, 0, 0)

    new_image = []
    # For each pixel of the image
    for i in range(height):
        new_line = []
        for j in range(width):
            new_pixel = [0, 0, 0]
            # For each composant of the pixel
            for RGB in range(3):
                new_value = 0
                # Compute the value using the convolution matrix
                for delta_i in range(msize):
                    for delta_j in range(msize):
                        new_value = new_value \
                                    + safe_getter(i + delta_i - msize // 2, j +
                                                  delta_j - msize // 2)[RGB] \
                                    * mat[delta_i][delta_j]
                new_pixel[RGB] = min(255, max(0, int(new_value)))
            new_line.append(tuple(new_pixel))
        new_image.append(new_line)
    return new_image


def sobel(img):
    width, height = len(img[0]), len(img)
    img = greyscale(img)

    # Compute the gradients for the two axis
    mat_grad_x = [[1, 0, -1], [2, 0, -2], [1, 0, -1]]
    mat_grad_y = [[1, 2, 1], [0, 0, 0], [-1, -2, -1]]
    grad_x = convolution(img, mat_grad_x)
    grad_y = convolution(img, mat_grad_y)

    # Create the new image and put pixels on
    new_img = []
    for i in range(height):
        new_line = []
        for j in range(width):
            gradient = int(
                    (grad_x[i][j][0] ** 2 + grad_y[i][j][0] ** 2) ** 0.5)
            new_line.append((gradient,) * 3)
        new_img.append(new_line)
    return new_img


def flou(img, rayon):
    # Initialize the convolution matrix
    mat = [[1] * rayon] * rayon
    for i in range(rayon):
        for j in range(rayon):
            dist = abs(i - rayon/2) + abs(j - rayon/2)
            # This is an approximation of a gaussian blur
            mat[i][j] = 2.0 / (max(1, dist) * rayon * rayon)
    # Theoritically we should do normalization after the convolution
    return convolution(img, mat)


img = umage.load("image_test.jpg")

mat = [[-1, -1, -1], [-1, 8, -1], [-1, -1, -1],
       [-1, -1, -1], [-1, 9, -1], [-1, -1, -1],
       [-2, 0, 0], [0, 1, 0], [0, 0, 2]]

r = convolution(img, mat)

umage.save(r)
