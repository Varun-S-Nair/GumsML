import os,sys
folder = 'C:/Users/Varun/Documents/WorkspaceForTheKids/aiGums/TensorFlowDemo/training_images/unhealthy'
for filename in os.listdir(folder):
       infilename = os.path.join(folder,filename)
       if not os.path.isfile(infilename): continue
       oldbase = os.path.splitext(filename)
       newname = infilename.replace('.jpeg', '.jpg')
       output = os.rename(infilename, newname)
# im = Image.open('Foto.jpg')
# im.save('Foto.png')
