FROM openjdk:17-slim

WORKDIR /app

COPY ./app /app

RUN apt-get update && apt-get install -y python3 python3-pip
RUN pip3 install --upgrade pip && pip3 install -r /app/requirements.txt

CMD ["uvicorn", "main:app", "--host", "0.0.0.0", "--port", "8000"]
