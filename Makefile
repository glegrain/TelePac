TEX = pdflatex

.PHONY: all clean

all: Rapport

Rapport: Rapport.tex
	$(TEX)  $^

view:
	open Rapport.pdf

clean:
	rm -rf *~
	rm -rf *.aux
	rm -rf *.out
	rm -rf *.log
