from fastapi import FastAPI
import os

app = FastAPI()
@app.get("/")
def read_root():
    return{"message" :"Hello from FastAPI v2 on Kubernetes - Isa is a pro ;)"}
@app.get("/status")
def status():
    return {"status": "API Running", "host": os.getenv("HOSTNAME")}