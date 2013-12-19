TEX = pdflatex

.PHONY: all clean

all: raport

descriptif: raport.tex
	$(TEX)  $^

view:
	open raport.pdf

clean:
	rm -rf *~
	rm -rf *.aux
	rm -rf *.out
	rm -rf *.log
