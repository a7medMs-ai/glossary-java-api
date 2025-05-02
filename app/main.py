from fastapi import FastAPI, File, UploadFile
import shutil
import os
from sdltb_handler import convert_sdltb

app = FastAPI()

@app.post("/convert")
async def convert(file: UploadFile = File(...)):
    input_path = f"/tmp/{file.filename}"
    output_path = input_path.replace(".sdltb", ".tbx")

    with open(input_path, "wb") as buffer:
        shutil.copyfileobj(file.file, buffer)

    convert_sdltb(input_path, output_path)

    return {"status": "done", "output_file": os.path.basename(output_path)}
