import React from 'react'
import { Input } from '@/components/ui/input'
import { Button } from '@/components/ui/button'
import { Separator } from '@radix-ui/react-separator'
import { Github, Discord, Background } from '@/assets/svg'


export function Login() {
    return (
        <div className="grid grid-cols-[30%_70%] w-screen h-screen">
            {/*Login*/}
            <div className="bg-bgSecondary flex flex-col justify-between px-8">
                {/* Título */}
                <div className="flex flex-col items-center gap-2 mt-8">
                    <h1 className="text-3xl font-[Poppins] text-white text-center">
                        Login
                    </h1>
                    <Separator className="w-15 border-t border-white" />
                </div>

                {/* Inputs e botão */}
                <div className="flex flex-col items-center gap-4">
                    <Input
                        placeholder="Email"
                        className="w-75"
                    />
                    <Input
                        type="password"
                        placeholder="Password"
                        className="w-75"
                    />
                    <Button className="w-70 h-10 rounded-md">
                        Login
                    </Button>
                </div>

                {/* Ícones no final */}
                <div className="flex flex-row items-center justify-center gap-4 mb-8">
                    <a
                        href='https://github.com/Maternal-da-Bolha-Tech'
                        target='_blank'
                        rel='noopener noreferrer'
                        className='hover:opacity-80 transition-opacity'
                    >
                        <Github color='white' size={28} />
                    </a>
                    <a
                        href='https://discord.gg/2zz6BEh4'
                        target='_blank'
                        rel='noopener noreferrer'
                        className='hover:opacity-80 transition-opacity'
                    >
                        <Discord color='white' size={28} />
                    </a>

                </div>
            </div>

            {/* Coluna da direita (Informações) */}
            <div className="bg-bgPrimary flex items-center justify-center relative overflow-hidden h-full">
                <div className="flex flex-col items-center justify-center z-10">
                    <h1 className="text-3xl font-[Poppins] text-white text-center">
                        Welcome to Our Application
                    </h1>
                    <p className="text-lg text-white mt-4">
                        Please login to continue
                    </p>
                </div>
                <div className="absolute bottom-0 inset-x-0 flex flex-row z-0">
                    
                </div>
            </div>
        </div>
    )
}