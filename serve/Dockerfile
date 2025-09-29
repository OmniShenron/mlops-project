FROM python:3.10-slim
WORKDIR /app
COPY wheelhouse /wheelhouse
RUN pip install --no-index --find-links=/wheelhouse fastapi uvicorn mlflow scikit-learn
COPY serve /app/serve
CMD ["uvicorn", "serve.app:app", "--host", "0.0.0.0", "--port", "8000"]
