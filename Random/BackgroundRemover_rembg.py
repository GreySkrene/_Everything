import sys
print(sys.executable)

import os
from rembg import remove
from PIL import Image

def remove_background(input_dir, output_dir):  
    # Iterate over each file in the input directory
    for filename in os.listdir(input_dir):
        if filename.endswith(".png") or filename.endswith(".jpg") or filename.endswith(".PNG"):
            # Construct the input and output file paths
            input_path = os.path.join(input_dir, filename)
            output_path = os.path.join(output_dir, filename)
            
            # Processing the image
            input_image = Image.open(input_path)
            
            # Removing the background from the given image
            output_image = remove(
                input_image,
            )

            
            # Saving the adjusted image to the output directory
            output_image.save(output_path)
            print(f"Processed {filename}")

# Specify the input and output directories
input_directory = "InputPhotos"
output_directory = "OutputPhotos"

# Remove the background from images in the input directory
remove_background(input_directory, output_directory)


"""
for image subtraction:
from PIL import Image
from PIL import ImageChops
image1 = Image.open("image1.jpg") # no cats
image2 = Image.open("image2.jpg") # with cats

image = ImageChops.subtract(image2, image1)

mask1 = Image.eval(image, lambda a: 0 if a <= 24 else 255) #or 0 if a == 0 else 255
mask2 = mask1.convert('1')

blank = Image.eval(image, lambda a: 0)

new = Image.composite(image2, blank, mask2) 
new.show()
"""
