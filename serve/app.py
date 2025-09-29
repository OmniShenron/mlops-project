from fastapi import FastAPI
import mlflow.pyfunc

app = FastAPI()

@app.get("/")
def read_root():
    return {"message": "MLflow model serving API"}
