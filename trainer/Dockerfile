FROM python:3.10-slim
WORKDIR /app
COPY wheelhouse /wheelhouse
RUN apt-get update && apt-get install -y git; \
pip install --no-index --find-links=/wheelhouse scikit-learn mlflow pandas
COPY trainer /app/trainer
CMD ["python", "trainer/train.py"]
