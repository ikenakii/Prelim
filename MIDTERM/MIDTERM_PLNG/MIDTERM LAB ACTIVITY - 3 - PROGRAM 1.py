def run_program_1():
    while True:
        message = input("Enter a message to encode (e.g., Hello Python): ").strip()
        if message and all(char.isalpha() or char.isspace() for char in message):
            break
        print("Invalid input! Please enter text containing only letters and spaces.")

    bytes_obj = message.encode('utf-8')
    print(f"1. Bytes object: {bytes_obj}")

    str_from_bytes = bytes_obj.decode('utf-8')
    print(f"2. Bytes to string: {str_from_bytes}")

    hex_str = bytes_obj.hex()
    print(f"3. Bytes to hex: {hex_str}")

    bytes_from_hex = bytes.fromhex(hex_str)
    print(f"4. Hex to bytes: {bytes_from_hex}")

    bytearray_direct = bytearray(message, 'utf-8')
    print(f"5. New bytearray: {bytearray_direct}")

    bytearray_from_bytes = bytearray(bytes_obj)
    print(f"6. Bytes to bytearray: {bytearray_from_bytes}")

    slice_start = message.find(" ") + 1 if " " in message else len(message) // 2
    sliced_bytes = bytes_obj[slice_start:]
    print(f"7. Sliced bytes: {sliced_bytes}")

    if len(bytearray_from_bytes) > 0:
        first_char = chr(bytearray_from_bytes[0])
        bytearray_from_bytes[0] = ord(first_char.lower())
    
    modified_message = bytearray_from_bytes.decode('utf-8')
    print(f"8. Modified message: {modified_message}")

if __name__ == "__main__":
    run_program_1()
