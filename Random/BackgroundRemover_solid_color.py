import os
import cv2
import numpy as np

def remove_background_color(input_dir, output_dir):
    # Create the output directory if it doesn't exist
    os.makedirs(output_dir, exist_ok=True)
    
    # Iterate over each file in the input directory
    for filename in os.listdir(input_dir):
        if filename.endswith(".png") or filename.endswith(".jpg") or filename.endswith(".PNG"):
            # Construct the input and output file paths
            input_path = os.path.join(input_dir, filename)
            output_path = os.path.join(output_dir, filename)
            
            # Read the input image
            img = cv2.imread(input_path)
            
            # Convert the image to BGRA format
            img = cv2.cvtColor(img, cv2.COLOR_BGR2BGRA)
            
            # Get the background color from the top-left pixel
            bgcolor = img[10, 10]
            # Or can use BGR Format:
            # bgcolor = [37, 150, 190] 
            # print(f"Background color: {bgcolor}")


            # Set the background color pixels to transparent #  + [255]
            img[np.all(img == bgcolor, axis=2)] = [0, 0, 0, 0]
            
            # Save the adjusted image
            cv2.imwrite(output_path, img)

# Specify the input and output directories
input_directory = "InputPhotos"
output_directory = "OutputPhotos"

# Remove the background color from images in the input directory
remove_background_color(input_directory, output_directory)

