#!/usr/bin/python

# This is an attempt to speed up the process of creating maps.
# Note: this script isn't complete. Only use it to build the 
# basic map structure without any wall or attributes
#
# You will then have to manually add the walls (with "null" 
# set to desired exits) and add other meta-data for the level.
#
# You can use http://jsonlint.com/ to validate the file.

import sys

# TODO: set all map attributes in this script

# define map size
width = 7
height = 7

for i in range(0, width):
	for j in range(0,height):

		# uncomment for simple "rxx" matrix representation
		# sys.stdout.write('r%d%d ' % (i,j))
		if i == 0:
			nExit = " null"
		else:
			nExit = "\"r"+str(i-1)+str(j)+"\""

		if i == height - 1:
			sExit = " null"
		else:
			sExit = "\"r"+str(i+1)+str(j)+"\""

		if j == 0:
			wExit = " null"
		else:
			wExit = "\"r"+str(i)+str(j-1)+"\""

		if j == width - 1:
			eExit = " null"
		else:
			eExit = "\"r"+str(i)+str(j+1)+"\"" 

		rName = "\"r"+str(i)+str(j)+"\""

		sys.stdout.write('{"Name": %s, "NorthExit": %s, "SouthExit": %s, "WestExit": %s, "EastExit": %s, "Attributes":    null }' % (rName,nExit,sExit,wExit,eExit))
		# separate objects with a comma
		if i < height - 1 or j < width - 1 :
			sys.stdout.write(", ")
	sys.stdout.write("\n")
