FROM python:3.10-slim
WORKDIR /app
COPY wheelhouse /wheelhouse
RUN pip install --no-index --find-links=/wheelhouse mlflow psycopg2-binary
CMD ["mlflow", "server", "--backend-store-uri", "postgresql://mlflow:mlflow@postgres:5432/mlflow", "--default-artifact-root", "/mlflow-artifacts", "--host", "0.0.0.0", "--port", "5000"]
