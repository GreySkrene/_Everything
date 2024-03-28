from scapy.all import *
import socket

# IP address and port of your C server
SERVER_IP = "192.168.0.83"
SERVER_PORT = 3000

def forward_packet(packet):
    # Forward packet to C server
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        try:
            s.connect((SERVER_IP, SERVER_PORT))
            s.sendall(packet)
        except Exception as e:
            print(f"Error forwarding packet: {e}")

def firewall(packet):
    # Check if the packet is an IP packet
    if IP in packet:
        src_ip = packet[IP].src
        dst_ip = packet[IP].dst
        print(f"Packet from {src_ip} to {dst_ip}")

        # Define your filtering rules here
        allowed_ips = ["192.168.0.83"]
        if src_ip in allowed_ips:
            print(f"Allowing packet from {src_ip} to {dst_ip}")
            forward_packet(packet)
            return

    # If packet does not pass filtering rules, drop it
    print(f"Blocking packet from {src_ip} to {dst_ip}")

# Sniff packets and apply the firewall function
sniff(filter="ip", prn=firewall)
