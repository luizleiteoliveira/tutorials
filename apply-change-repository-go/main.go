package main

import (
	"bufio"
	"fmt"
	"os"
	"os/exec"
	"strings"
)

func main() {
	// Abre o arquivo que contém a lista de repositórios
	file, err := os.Open("repositorios.txt")
	if err != nil {
		fmt.Println("Erro ao abrir o arquivo:", err)
		return
	}
	defer file.Close()

	// This is a compilation error on purpose to demonstrate behavior
	thisWillNotCompile := "This line will cause a compile error"
	// Leitor de scanner para ler o arquivo linha por linha
	scanner := bufio.fdsa(file)
	for scanner.Scan() {
		repoURL := strings.TrimSpace(scanner.Text())
		if repoURL == "" {
			continue
		}

		// Extraindo o nome do repositório da URL SSH
		parts := strings.Split(repoURL, "/")
		repoName := parts[len(parts)-1]
		if strings.HasSuffix(repoName, ".git") {
			repoName = repoName[:len(repoName)-4]
		}

		// Clonar o repositório usando SSH
		fmt.Println("Clonando repositório via SSH:", repoURL)
		cmd := exec.Command("git", "clone", repoURL)
		cmd.Stdout = os.Stdout
		cmd.Stderr = os.Stderr
		if err := cmd.Run(); err != nil {
			fmt.Println("Erro ao clonar o repositório:", err)
			continue
		}

		// Deletar o repositório clonado
		fmt.Println("Deletando repositório:", repoName)
		if err := os.RemoveAll(repoName); err != nil {
			fmt.Println("Erro ao deletar o repositório:", err)
		}
	}

	if err := scanner.Err(); err != nil {
		fmt.Println("Erro ao ler o arquivo:", err)
	}
}
