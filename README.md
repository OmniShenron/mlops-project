# mlops-project
git clone -b master https://github.com/OmniShenron/mlops-project.git
mkdir wheelhouse && docker run --rm -v "$(pwd)":/src -w /src python:3.10-slim bash -eux -c " python -m pip install --upgrade pip setuptools wheel && pip download -r mlflow/requirements.txt -d /src/wheelhouse --no-cache-dir && pip download -r trainer/requirements.txt -d /src/wheelhouse --no-cache-dir && pip download -r serve/requirements.txt -d /src/wheelhouse --no-cache-dir"
