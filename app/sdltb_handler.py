import subprocess

def convert_sdltb(input_file, output_file):
    command = [
        "java",
        "-jar", "app/sdltb_converter.jar",  # المسار حسب مكان ملف الجار
        input_file,
        output_file
    ]
    subprocess.run(command, check=True)
