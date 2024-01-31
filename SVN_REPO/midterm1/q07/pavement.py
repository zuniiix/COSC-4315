#!/usr/bin/env python3
from paver.easy import *
import os
import glob
import shutil
import sys

sys.path.append(os.path.dirname(__file__))

@task
def setup():
    sh('python3 -m pip install -U coverage')
    sh('python3 -m pip install -U pytest')

@task
def clean():
    for pycfile in glob.glob("*/*/*.pyc"): os.remove(pycfile)
    for pycache in glob.glob("*/__pycache__"): os.removedirs(pycache)
    for pycache in glob.glob("./__pycache__"): shutil.rmtree(pycache)
    try:
        shutil.rmtree(os.getcwd() + "/cover")
    except:
        pass

@task
@needs(['setup', 'clean'])
def default():
    pass