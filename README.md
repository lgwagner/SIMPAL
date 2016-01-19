# SIMPAL

SIMPAL (Static IMPerative AnAlyzer) is a tool built to perform compositional reasoning of imperative programs.

It features a domain specific language called Limp (a portmanteau of Lustre imperative). These programs are
then compiled into a control flow graph (CFG) and translated into a Lustre model, which can then be analzyed.

The analysis is performed by JKind, which is embedded into the tool directly, thus it is not necessary to install it.

The tool requires the user to install GraphViz and the Yices SMT solver.

A document describing the function and features of the tool is available in the source repositor.
